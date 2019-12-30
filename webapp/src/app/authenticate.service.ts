import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { User } from './home/user.model';
import { UserAuthService } from './user-auth.service';

@Injectable({
    providedIn:'root'
})
export class AuthenticateService{
    baseUrl = environment.baseUrl;
    constructor(private httpClient: HttpClient,private userAuthService:UserAuthService) { }
    public authenticate(user: string, password: string): Observable<any> {
        let credentials = btoa(user + ':' + password);
        console.log(user + ':' + password);
        let headers = new HttpHeaders();
        headers = headers.set('Authorization', 'Basic ' + credentials);
        console.log({ headers });
        return this.httpClient.get(this.baseUrl+'/authenticate', { headers })
    }
    public getUserDetails(user:string){
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + this.userAuthService.getToken()
            })
        };
        return this.httpClient.get<User>(this.baseUrl+'/users/'+user,httpOptions);
    }
}