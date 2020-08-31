import { Component, OnInit, EventEmitter, Output, OnDestroy } from '@angular/core';
import { AuthenticationService } from 'src/app/services/auth/authentication.service';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit, OnDestroy {
  @Output() sidenavToggle = new EventEmitter<void>();
  isAuth: boolean = this.authService.isAuth();
  isMentor: boolean = this.authService.isMentor();
  authSubscription: Subscription;
  constructor(private authService: AuthenticationService, private router: Router) { }

  ngOnInit(): void {
    this.authSubscription = this.authService.authChange.subscribe(authStatus => {
      this.isAuth = authStatus;
    });
  }

  ngOnDestroy() {
    this.authSubscription.unsubscribe();
  }

  onToggleSidenav() {
    this.sidenavToggle.emit();
  }

  logout() : void {
    this.authService.logout();
  }

  myProfile() : void {
    if (this.authService.isProfileComleted())
      this.router.navigate(['/me']);
    else this.router.navigate(['/mentorprofilecreation']);
  }
}
