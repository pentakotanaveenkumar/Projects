import { DonationDetails } from '../search/donation-details.model';
import { Hospital } from '../hospital-details/hospital.model';

export class DonorSlotDetails{
    id:number;
    donationDate:Date;
    donationTime:string;
    hospital:Hospital;
    donationDeatils:DonationDetails;
}