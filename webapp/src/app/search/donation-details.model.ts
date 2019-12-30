import { State } from './state.model';
import { City } from './city.model';
import { Area } from './area.model';
import { BloodGroup } from './blood-group.model';

export class DonationDetails{
    id:number;
    state:State;
    city:City;
    area:Area;
    bloodGroup:BloodGroup;
}