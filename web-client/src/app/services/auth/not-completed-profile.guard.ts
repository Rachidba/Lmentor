import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Injectable } from '@angular/core';
import { AuthenticationService } from './authentication.service';

@Injectable()
export class NotCompletedProfileGuard implements CanActivate{
    constructor(private authService: AuthenticationService, private router: Router) {}
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        if (!this.authService.isProfileComleted())
            this.router.navigate(['/mentorprofilecreation']);
        return true;
    }
}