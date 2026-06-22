import { Routes } from '@angular/router';

import { Chat } from './components/chat/chat';
import { AdminLogin } from './components/admin-login/admin-login';
import { AdminDashboard } from './components/admin-dashboard/admin-dashboard';

export const routes: Routes = [
  {
    path: '',
    component: Chat
  },
  {
    path: 'admin/login',
    component: AdminLogin
  },
  {
    path: 'admin/dashboard',
    component: AdminDashboard
  }
];