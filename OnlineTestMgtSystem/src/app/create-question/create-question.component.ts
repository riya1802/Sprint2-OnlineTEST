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
  // public answer:Answer[]=[];
  answer:Array<Answer>=[];
  // answer:Answer=new Answer(0,"");
 

  answerId1:number;
  value1:string;
  answer1:Answer=new Answer(this.answerId1,this.value1);
  // answerId2:number;
  // value2:string;
  // answer2:Answer=new Answer(this.answerId2,this.value2);
  // answerId3:number;
  // value3:string;
  // answer3:Answer=new Answer(this.answerId3,this.value3);
  // answerId4:number;
  // value4:string;
  // answer4:Answer=new Answer(this.answerId4,this.value4);

  
  ngOnInit() :void{
  }

  save(){
    
    this.answer.push(this.answer1);

    // this.answer.push(this.answer2);

    // this.answer.push(this.answer3);

    // this.answer.push(this.answer4);

    this.question.questionOptions = this.answer;


    this.service.addQuestion(this.test.testId,this.question).subscribe((data)=>this.message=data);
   }
}

