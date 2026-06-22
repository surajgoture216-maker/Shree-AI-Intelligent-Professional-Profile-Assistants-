export interface Message {
  sender: 'user' | 'ai';
  content: string;
  timestamp?: Date;
}