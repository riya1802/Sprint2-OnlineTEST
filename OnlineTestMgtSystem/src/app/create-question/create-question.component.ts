import { Component, OnInit } from '@angular/core';
import { QuestionService } from '../service/question.service';
import { Question } from '../entity/question';
import { Test } from '../entity/test';
import { Answer } from '../entity/answer';;
@Component({
  selector: 'app-create-question',
  templateUrl: './create-question.component.html',
  styleUrls: ['./create-question.component.css']
})
export class CreateQuestionComponent implements OnInit {
 
  constructor(private service:QuestionService) { }
  
  message:any;
  question: Question=new Question(0,"",0,0,0,0,null);
  test:Test=new Test(0,"",null,0,0,0,null,null);
  testId:number;
  answerId:number;
  value:string;
  
  // answer:Answer=new Answer(0,"");
  answer:Answer[]=[];
  answerId1:number;
  value1:string;
  answerId2:number;
  value2:string;
  answerId3:number;
  value3:string;
  answerId4:number;
  value4:string;

  
 questionOptions:Array<Answer> = [
    {answerId:this.answerId1,value: this.value1},
    {answerId:this.answerId2,value: this.value2},
    {answerId:this.answerId3,value: this.value3},
    {answerId:this.answerId4,value: this.value4}
  ];
    

  
  ngOnInit() {
    this.question.questionOptions[4];
  }
   adQuestion(testId,question){
    let resp= this.service.addQuestion(testId,question);
    resp.subscribe((data)=>this.message=data);
   }
}

