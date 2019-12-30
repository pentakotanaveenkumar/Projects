import { State } from '../search/state.model';
import { City } from '../search/city.model';
import { Area } from '../search/area.model';
import { BloodGroup } from '../search/blood-group.model';

export class RequestPostingDetails{
    id:number;
    state:State;
    city:City;
    area:Area;
    bloodGroup:BloodGroup;
}