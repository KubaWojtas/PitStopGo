import {Observable} from "rxjs";
import {Driver} from "../driver/model/driver.model";
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Calendar} from "../calendar/model/calendar.model";

const baseUrl = 'http://localhost:8080/api/calendars';

@Injectable({
  providedIn: 'root'
})
export class CalendarService {
  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Calendar[]> {
    return this.http.get<Calendar[]>(baseUrl)
  }

  get(id: any): Observable<Calendar> {
    return this.http.get(`${baseUrl}/${id}`);
  }

  generateCalendar(id: any): Observable<Calendar> {
    return this.http.get(`${baseUrl}/${id}/generate`);
  }

  simulateCalendar(id: any): Observable<Calendar> {
    return this.http.get(`${baseUrl}/${id}/simulate`);
  }

  create(data: any): Observable<any> {
    return this.http.post(`${baseUrl}/add`, data);
  }

  addRace(cId: any, rId: any): Observable<any> {
    return this.http.post(`${baseUrl}/${cId}/addRace/${rId}`, null);
  }

  update(id: any, data: any): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }

  delete(id: any): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}/delete`);
  }
}
