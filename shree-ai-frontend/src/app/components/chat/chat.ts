import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ChatService } from '../../services/chat';
import { Message } from '../../models/message';

@Component({
  selector: 'app-chat',
  standalone: true,
  imports: [FormsModule,
      CommonModule
  ],
  templateUrl: './chat.html',
  styleUrl: './chat.css'
})
export class Chat {

  private chatService = inject(ChatService);

  question = '';

  loading = false;

  messages: Message[] = [];

  sendMessage() {

    if (!this.question.trim()) {
      return;
    }

    const userQuestion = this.question;

    this.messages.push({
      sender: 'user',
      content: userQuestion
    });

    this.question = '';

    this.loading = true;

    this.chatService.askQuestion(userQuestion)
      .subscribe({
        next: (response) => {

          this.messages.push({
            sender: 'ai',
            content: response.answer
          });

          this.loading = false;
        },

        error: (error) => {

          this.messages.push({
            sender: 'ai',
            content: 'Unable to connect to Shree AI.'
          });

          this.loading = false;
        }
      });
  }
}