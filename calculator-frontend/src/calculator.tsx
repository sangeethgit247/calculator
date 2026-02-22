import React, { useState } from 'react';
import axios from 'axios';
import CalcButton from './calcbutton';

const Calculator: React.FC = () => {
  // expression tracks the full string (e.g., "12+5-3")
  const [expression, setExpression] = useState<string>("");
  // display tracks what the user sees (usually just the current number)
  const [display, setDisplay] = useState<string>("0");
  const [isDone, setIsDone] = useState<boolean>(false);

  // BLOCK: Handling Numbers
  const handleNumber = (num: string) => {
    if (display === "0" || isDone) {
      setDisplay(num);
      setExpression(isDone ? num : expression + num);
      setIsDone(false);
    } else {
      setDisplay(display + num);
      setExpression(expression + num);
    }
  };

  // BLOCK: Handling Operators
  const handleOperator = (op: string) => {
    setIsDone(false);
    setDisplay("0"); // Clear display for the next number
    setExpression(expression + op); // Append operator to the full string
  };

  // BLOCK: Backend Communication
  const handleCalculate = async (expression: string) => {
    try {
      const response = await axios.post(`${import.meta.env.VITE_API_URL}/math/operation`, 
      {},{
        params: {
          expression: expression
        },
        // withCredentials: false
      });
      const result = response.data.toString();
      setDisplay(result);
      setExpression(result); // Allow user to continue operating on the result
      setIsDone(true);
    } catch (error) {
      setDisplay("Error");
      setExpression("");
    }
  };

  const clear = () => {
    setDisplay("0");
    setExpression("");
  };

  return (
    <div className="flex flex-col items-center justify-center min-h-screen bg-slate-100">
      <div className="bg-black p-6 rounded-[2.5rem] w-80 shadow-2xl">
        
        {/* Expression Preview (Small text above main display) */}
        <div className="text-gray-500 text-right text-sm h-6 px-4 truncate">
          {expression}
        </div>
        
        {/* Main Display */}
        <div className="text-white text-5xl text-right mb-6 px-4 py-6 overflow-hidden">
          {display}
        </div>

        <div className="grid grid-cols-4 gap-3">
          <CalcButton label="AC" value="clear" onClick={clear} variant="action" className="col-span-2" />
          <CalcButton label="%" value="%" onClick={handleOperator} variant="op" />
          <CalcButton label="÷" value="/" onClick={handleOperator} variant="op" />
          <br />

          <CalcButton label="7" value="7" onClick={handleNumber} />
          <CalcButton label="8" value="8" onClick={handleNumber} />
          <CalcButton label="9" value="9" onClick={handleNumber} />
          <CalcButton label="×" value="*" onClick={handleOperator} variant="op" />
          <br />

          <CalcButton label="4" value="4" onClick={handleNumber} />
          <CalcButton label="5" value="5" onClick={handleNumber} />
          <CalcButton label="6" value="6" onClick={handleNumber} />
          <CalcButton label="-" value="-" onClick={handleOperator} variant="op" />
          <br />

          <CalcButton label="1" value="1" onClick={handleNumber} />
          <CalcButton label="2" value="2" onClick={handleNumber} />
          <CalcButton label="3" value="3" onClick={handleNumber} />
          <CalcButton label="+" value="+" onClick={handleOperator} variant="op" />
          <br />

          <CalcButton label="0" value="0" onClick={handleNumber} className="col-span-2" />
          <CalcButton label="." value="." onClick={handleNumber} />
          <CalcButton label="=" value={`${expression}`} onClick={handleCalculate} variant="op" />
        </div>
      </div>
    </div>
  );
};

export default Calculator;