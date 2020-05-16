import { Component, OnInit } from '@angular/core';
import { Test } from '../entity/test';
import { TestService } from '../service/test.service';

@Component({
  selector: 'app-add-test',
  templateUrl: './add-test.component.html',
  styleUrls: ['./add-test.component.css']
})
export class AddTestComponent implements OnInit {

  test: Test= new Test(0,"",null,0,0,0,null,null);
  message:any;
  constructor(private service:TestService) { }

  ngOnInit(): void {
  }

  public adTest(test){
    let add=this.service.addTest(test);
    add.subscribe((data)=>this.message=data);
  }
}
