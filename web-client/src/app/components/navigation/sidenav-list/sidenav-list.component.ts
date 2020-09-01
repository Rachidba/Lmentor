import { Component, OnInit, EventEmitter, Output, OnDestroy } from '@angular/core';
import { AuthenticationService } from 'src/app/services/auth/authentication.service';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sidenav-list',
  templateUrl: './sidenav-list.component.html',
  styleUrls: ['./sidenav-list.component.scss']
})
export class SidenavListComponent implements OnInit, OnDestroy {
  @Output() closeSidenav = new EventEmitter<void>();
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

  onCloseSidenav() {
    this.closeSidenav.emit();
  }

  logout() {
    this.authService.logout();
    this.onCloseSidenav();
  }

  myProfile() : void {
    if (this.authService.isProfileComleted())
      this.router.navigate(['/me']);
    else this.router.navigate(['/mentorprofilecreation']);

    this.onCloseSidenav();
  }
}