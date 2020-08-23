import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { RegisterComponent } from './components/auth/register/register.component';
import { LoginComponent } from './components/auth/login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { AuthenticationService } from './services/authentication.service';
import { EducationFormComponent } from './components/education-form/education-form.component';
import { ExperienceFormComponent } from './components/experience-form/experience-form.component';
import { MentorCreationFormComponent } from './components/mentor-creation-form/mentor-creation-form.component';
import { MentorService } from './services/mentor/mentor.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MentorCreationHeaderComponent } from './components/mentor-creation/mentor-creation-header/mentor-creation-header.component';
import { WizardStepComponent } from './components/mentor-creation/wizard-step/wizard-step.component';
import { MentorCreationPersonalComponent } from './components/mentor-creation/mentor-creation-personal/mentor-creation-personal.component';
import { MentorCreationExpertiseComponent } from './components/mentor-creation/mentor-creation-expertise/mentor-creation-expertise.component';
import { MentorCreationProfileComponent } from './components/mentor-creation/mentor-creation-profile/mentor-creation-profile.component';
import { StoreModule } from '@ngrx/store';
import { reducers, metaReducers } from './state';
import { StoreDevtoolsModule } from '@ngrx/store-devtools';
import { MaterialModule } from './material.module';
import { HeaderComponent } from './components/navigation/header/header.component';
import { SidenavListComponent } from './components/navigation/sidenav-list/sidenav-list.component';
import { SearchComponent } from './components/mentors/search/search.component';
import { MentorItemComponent } from './components/mentors/mentor-item/mentor-item.component';
import { StudentProfileCreationComponent } from './components/profile-creation/student-profile-creation/student-profile-creation.component';
import { MentorProfileCreationComponent } from './components/profile-creation/mentor-profile-creation/mentor-profile-creation.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    RegisterComponent,
    LoginComponent,
    EducationFormComponent,
    ExperienceFormComponent,
    MentorCreationFormComponent,
    MentorCreationHeaderComponent,
    WizardStepComponent,
    MentorCreationPersonalComponent,
    MentorCreationExpertiseComponent,
    MentorCreationProfileComponent,
    HeaderComponent,
    SidenavListComponent,
    SearchComponent,
    MentorItemComponent,
    StudentProfileCreationComponent,
    MentorProfileCreationComponent,
    
  ],
  imports: [
    
    MaterialModule,
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FlexLayoutModule,
    StoreModule.forRoot(reducers, { metaReducers }),
    StoreDevtoolsModule.instrument({
      maxAge: 25
    }),
  ],
  providers: [
    AuthenticationService,
    MentorService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
