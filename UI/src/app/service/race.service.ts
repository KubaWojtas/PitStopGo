import {Observable} from "rxjs";
import {Driver} from "../driver/model/driver.model";
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";

const baseUrl = 'http://localhost:8080/api/races';

@Injectable({
  providedIn: 'root'
})
export class RaceService {
  constructor(private http: HttpClient) {
  }

  get(id: any): Observable<Driver> {
    return this.http.get(`${baseUrl}/${id}`);
  }

  simulateRace(id: any): Observable<Driver> {
    return this.http.get(`${baseUrl}/${id}/simulate`);
  }

  simulateAllRaces(): Observable<Driver> {
    return this.http.get(`${baseUrl}/simulateAllRaces`);
  }

  create(data: any): Observable<any> {
    return this.http.post(`${baseUrl}/add`, data);
  }

}
