import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  private baseUrl = 'http://localhost:9090/test'

  constructor(private http:HttpClient) { }
public  getQuestions(){
  return this.http.get("http://localhost:9090/admin/viewAllQuestions");
}
public deleteQuestion(questionId){
  return this.http.delete("http://localhost:9090/admin/deleteQuestion/"+questionId);
}
public addQuestion(testId, question){
  return this.http.post(`http://localhost:9090/admin/addQuestion/${testId}`,question,{responseType:'text' as 'json'});
}
}