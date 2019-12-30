import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from '../auth.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  isLoginValid:boolean;
  authSource: boolean = false;
  constructor(private authService: AuthService, private router: Router, private route: ActivatedRoute) {
    this.authSource = this.route.snapshot.queryParams['notLogged'];
  }
  ngOnInit() {
  }
  onSubmit(form: NgForm) {
    this.authService.logIn(form.value.username, form.value.password);
    this.isLoginValid=this.authService.inValidUser;
  }
}
