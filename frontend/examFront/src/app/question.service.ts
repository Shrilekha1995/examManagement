import { Injectable } from '@angular/core';
import{HttpClient,HttpClientModule,HttpHeaders } from '@angular/common/http';
import{Observable} from 'rxjs';
import { Question } from "src/app/Model/Question.model";


@Injectable({
  providedIn: 'root'
})
export class QuestionService {

constructor(private http: HttpClient) { }

addQuestion(question:Question,tid:number):Observable<any> {

  return this.http.post(`http://localhost:8080/addQuestion/${tid}`, question);
}

deleteQuestion(qid:number,tid:number):Observable<any> {
  return this.http.delete(`http://localhost:8080/deleteQuestion/${qid}/${tid}`);
}

updateQuestion(question:Question):Observable<any>{
  return this.http.put(`http://localhost:8080/updateQuestion`, question);
}
}
