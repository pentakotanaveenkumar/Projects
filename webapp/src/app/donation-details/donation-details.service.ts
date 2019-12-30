import { Injectable } from "@angular/core";
import { UserAuthService } from '../user-auth.service';
import { environment } from 'src/environments/environment';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { DonationDetails } from '../search/donation-details.model';
import { Observable } from 'rxjs';
import { SlotDetails } from '../hospital-details/slot.model';
import { DonorSlotDetails } from './donor-slot-details.model';

@Injectable({
    providedIn: 'root'
})
export class DonationDetailsService {
    baseUrl = environment.baseUrl;
    donationDetails:DonationDetails;
    constructor(private httpClient: HttpClient, private userAuthService: UserAuthService) {

    }
    addDonationDetails(donationDetails: DonationDetails)/*: Observable<any>*/ {
        this.donationDetails=donationDetails;
        /*const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + this.userAuthService.getToken()
            })
        };
        return this.httpClient.post(`${this.baseUrl + "/donationDetails"}`, donationDetails, httpOptions)*/
    }
    addSlotDetails(slotDetails: SlotDetails) {
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + this.userAuthService.getToken()
            })
        };
        return this.httpClient.post(`${this.baseUrl + "/slotDetails"}`, slotDetails, httpOptions)
    }
    addDonorSlotDetails(donorSlotDetails: DonorSlotDetails) {
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + this.userAuthService.getToken()
            })
        };
        return this.httpClient.post(`${this.baseUrl + "/donorSlotDeatils"}`, donorSlotDetails, httpOptions)
    }
    isActiveDonor(username: String):Observable<any> {
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + this.userAuthService.getToken()
            })
        };
        return this.httpClient.get<boolean>(`${this.baseUrl + "/donationDetails/"+username}`, httpOptions)
    }
    isHeActiveDonor(username: String):Observable<any> {
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + this.userAuthService.getToken()
            })
        };
        return this.httpClient.get<boolean>(`${this.baseUrl + "/slotDetails/"+username}`, httpOptions)
    }
}