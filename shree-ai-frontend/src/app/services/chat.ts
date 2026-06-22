import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { ChatRequest } from '../models/chat-request';
import { ChatResponse } from '../models/chat-response';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ChatService {

  private http = inject(HttpClient);

  private apiUrl = `${environment.apiUrl}/api/chat`;

  askQuestion(question: string): Observable<ChatResponse> {

    const request: ChatRequest = {
      question: question
    };

    return this.http.post<ChatResponse>(
      this.apiUrl,
      request
    );
  }
}