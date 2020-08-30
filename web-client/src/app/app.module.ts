import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { RegisterComponent } from './components/auth/register/register.component';
import { LoginComponent } from './components/auth/login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { AuthenticationService } from './services/auth/authentication.service';
import { AppSettingsService } from './services/AppSettingsService.service';
import { CategoryService } from './services/categories/category.service';
import { MentorService } from './services/mentors/mentor.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FlexLayoutModule } from '@angular/flex-layout';
import { StoreDevtoolsModule } from '@ngrx/store-devtools';
import { MaterialModule } from './material.module';
import { HeaderComponent } from './components/navigation/header/header.component';
import { SidenavListComponent } from './components/navigation/sidenav-list/sidenav-list.component';
import { SearchComponent } from './components/mentors/search/search.component';
import { MentorItemComponent } from './components/mentors/mentor-item/mentor-item.component';
import { StudentProfileCreationComponent } from './components/profile-creation/student-profile-creation/student-profile-creation.component';
import { MentorProfileCreationComponent } from './components/profile-creation/mentor-profile-creation/mentor-profile-creation.component';
import { JwtHelperService } from '@auth0/angular-jwt';
import { CustomHttpInterceptor } from 'src/app/services/CustomHttpInterceptor';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { MentorProfileComponent } from './components/mentors/mentor-profile/mentor-profile.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    RegisterComponent,
    LoginComponent,
    HeaderComponent,
    SidenavListComponent,
    SearchComponent,
    MentorItemComponent,
    StudentProfileCreationComponent,
    MentorProfileCreationComponent,
    MentorProfileComponent,
    
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
    StoreDevtoolsModule.instrument({
      maxAge: 25
    }),
  ],
  providers: [
    AuthenticationService,
    MentorService,
    CategoryService,
    {  
      provide: HTTP_INTERCEPTORS,
      useClass: CustomHttpInterceptor,
      multi: true
    },
    JwtHelperService,
    AppSettingsService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
