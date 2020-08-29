import { Component, OnInit, EventEmitter, Output, OnDestroy } from '@angular/core';
import { AuthenticationService } from 'src/app/services/auth/authentication.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-sidenav-list',
  templateUrl: './sidenav-list.component.html',
  styleUrls: ['./sidenav-list.component.scss']
})
export class SidenavListComponent implements OnInit, OnDestroy {
  @Output() closeSidenav = new EventEmitter<void>();
  isAuth = this.authService.isAuth();
  authSubscription: Subscription;
  constructor(private authService: AuthenticationService) { }

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
}