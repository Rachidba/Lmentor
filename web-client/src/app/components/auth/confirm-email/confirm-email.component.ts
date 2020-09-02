import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/auth/authentication.service';

@Component({
  selector: 'app-confirm-email',
  templateUrl: './confirm-email.component.html',
  styleUrls: ['./confirm-email.component.css']
})
export class ConfirmEmailComponent implements OnInit {
  validatingEmail: boolean = true;
  constructor(private route: ActivatedRoute, private aurhService: AuthenticationService, private router: Router) { }

  ngOnInit(): void {
    const token = this.route.snapshot.queryParamMap.get('token');
    this.aurhService.confirmEmail(token).subscribe(res => {
      this.router.navigate(['/login'], { queryParams: { fromConfirmation: 'true' } });
    }, 
    (err: HttpErrorResponse) => {
      this.validatingEmail = false;
    });
  }

}
