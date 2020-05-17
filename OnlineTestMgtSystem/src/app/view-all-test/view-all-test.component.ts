import { Component, OnInit } from '@angular/core';
import { TestService } from '../service/test.service';
import { Test } from '../entity/test';

@Component({
  selector: 'app-view-all-test',
  templateUrl: './view-all-test.component.html',
  styleUrls: ['./view-all-test.component.css']
})
export class ViewAllTestComponent implements OnInit {

  
  test: any= new Test(0,"",null,0,0,0,null,null);
  constructor(private service:TestService) { }

  ngOnInit() {
    let t= this.service.viewAllTest();
    t.subscribe((data)=>this.test=data);
  }
  public delTest(testId){
    let del=this.service.deleteTest(testId);
    del.subscribe((data)=>this.test=data);
    alert("are you sure you want to delete the test?")
  }

}
