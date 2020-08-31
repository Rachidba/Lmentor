import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { RegisterComponent } from './components/auth/register/register.component';
import { LoginComponent } from './components/auth/login/login.component';
import { SearchComponent } from './components/mentors/search/search.component';
import { NotAuthenticatedGard } from './services/auth/not-authenticated.guard';
import { NotCompletedProfileGuard } from './services/auth/not-completed-profile.guard';
import { AuthenticatedGard } from './services/auth/authenticated.guard';
import { MentorProfileCreationComponent } from './components/profile-creation/mentor-profile-creation/mentor-profile-creation.component';
import { MentorProfileComponent } from './components/mentors/mentor-profile/mentor-profile.component';
import { MyMentorProfileComponent } from './components/my-profile/my-mentor-profile/my-mentor-profile.component';


const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'register', component: RegisterComponent, canActivate: [AuthenticatedGard]  },
  { path: 'login', component: LoginComponent, canActivate: [AuthenticatedGard]  },
  { path: 'mentors', component: SearchComponent  },
  { path: 'mentorprofilecreation', component: MentorProfileCreationComponent, canActivate: [NotAuthenticatedGard] },
  { path: 'home', redirectTo : '/' },
  { path: 'mentors/:id', component: MentorProfileComponent },
  { path: 'me', component: MyMentorProfileComponent, canActivate: [NotAuthenticatedGard] },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [
    NotAuthenticatedGard,
    AuthenticatedGard,
    NotCompletedProfileGuard
  ]
})
export class AppRoutingModule { }
