import { CanActivate, RouterStateSnapshot, ActivatedRouteSnapshot } from "@angular/router";
import { Router } from "@angular/router";
import { Observable, Observer } from "rxjs";
import { Injectable } from "@angular/core";
import { AuthService } from './home/auth.service';
@Injectable({
    providedIn: 'root'
})
export class AuthGaurdService implements CanActivate {
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | Observable<boolean> | Promise<boolean> {

        this.authservice.redirectUrl = state.url;
        console.log('url', state.url);
        return Observable.create((observer: Observer<boolean>) => {
            if (this.authservice.loggedIn) {
                console.log('loggedIn');
                observer.next(true);
            } else {
                console.log('Not loggedIn');
                this.router.navigate(['login'], { queryParams: { from: state.url.substr(1) }});
            }
        });
    }

    constructor(private authservice:AuthService, private router: Router) { }

}