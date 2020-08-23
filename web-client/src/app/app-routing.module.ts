import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { RegisterComponent } from './components/auth/register/register.component';
import { LoginComponent } from './components/auth/login/login.component';
import { SearchComponent } from './components/mentors/search/search.component';
import { AuthGard } from './services/auth.guard';
import { MentorProfileCreationComponent } from './components/profile-creation/mentor-profile-creation/mentor-profile-creation.component';


const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'search', component: SearchComponent },
  { path: 'mentorprofilecreation', component: MentorProfileCreationComponent, canActivate: [AuthGard] },
  { path: 'home', redirectTo : '/' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [AuthGard]
})
export class AppRoutingModule { }
