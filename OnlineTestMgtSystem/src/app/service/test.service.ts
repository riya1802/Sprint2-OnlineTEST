import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";



@Injectable({
  providedIn: 'root'
})
export class TestService {

  constructor(private httpClient: HttpClient) { }

  public viewAllTest() {
    return this.httpClient.get("http://localhost:9090/admin/viewAllTests");
  }
  public addTest(Test){
    return this.httpClient.post("http://localhost:9090/admin/addTest", Test, {responseType:'text' as 'json'});
  }
  public updateTest(Test){
    return this.httpClient.put("http://localhost:9090/admin/updateTest", Test);
  }
  public deleteTest(testId){
    return this.httpClient.delete("http://localhost:9090/admin/deleteTest/" + testId);
  }
}
