import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { AuthenticationService } from './services/authentication.service';
import { EducationFormComponent } from './components/education-form/education-form.component';
import { ExperienceFormComponent } from './components/experience-form/experience-form.component';
import { MentorCreationFormComponent } from './components/mentor-creation-form/mentor-creation-form.component';
import { MentorService } from './services/mentor/mentor.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MentorCreationHeaderComponent } from './components/mentor-creation/mentor-creation-header/mentor-creation-header.component';
import { WizardStepComponent } from './components/mentor-creation/wizard-step/wizard-step.component';
import { MentorCreationPersonalComponent } from './components/mentor-creation/mentor-creation-personal/mentor-creation-personal.component';
import { MentorCreationExpertiseComponent } from './components/mentor-creation/mentor-creation-expertise/mentor-creation-expertise.component';
import { MatRadioModule } from '@angular/material/radio';
import { MentorCreationProfileComponent } from './components/mentor-creation/mentor-creation-profile/mentor-creation-profile.component';
import { StoreModule } from '@ngrx/store';
import { reducers, metaReducers } from './state';
import { StoreDevtoolsModule } from '@ngrx/store-devtools';

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
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    FlexLayoutModule,
    MatRadioModule,
    MatSelectModule,
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