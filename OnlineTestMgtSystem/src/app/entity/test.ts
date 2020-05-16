import { Question } from './question'
export class Test{
    constructor(
    testId:number,
	testTitle:string,
	testQuestions:Array<Question>,
    testDuration:number,
	testTotalMarks:number,
	currentQuestion:number,
	startTime:Date,
     endTime:Date
    ){}
    testId:number;
	testTitle:string;
	testQuestions:Array<Question>;
    testDuration:number;
	testTotalMarks:number;
	currentQuestion:number;
	startTime:Date;
     endTime:Date;
}