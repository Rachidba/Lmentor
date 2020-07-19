import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { MentorCreationFormComponent } from './components/mentor-creation-form/mentor-creation-form.component';
import { MentorCreationPersonalComponent } from './components/mentor-creation/mentor-creation-personal/mentor-creation-personal.component';
import { MentorCreationExpertiseComponent } from './components/mentor-creation/mentor-creation-expertise/mentor-creation-expertise.component';
import { MentorCreationProfileComponent } from './components/mentor-creation/mentor-creation-profile/mentor-creation-profile.component';


const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'MentorCreationPersonal', component: MentorCreationPersonalComponent },
  { path: 'MentorCreationExpertise', component: MentorCreationExpertiseComponent },
  { path: 'MentorCreationProfile', component: MentorCreationProfileComponent },
  { path: 'home', redirectTo : '/' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
