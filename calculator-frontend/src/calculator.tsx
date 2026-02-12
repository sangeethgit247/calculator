import React, { useState } from 'react';
import axios from 'axios';

// TypeScript interface for our request
interface CalcRequest {
  elementOne: number;
  elementTwo: number;
  operationType: string;
}

const Calculator: React.FC = () => {
  const [inputs, setInputs] = useState({ n1: 0, n2: 0 });
  const [result, setResult] = useState<number | null>(null);

  const handleCalc = async (op: string) => {
    const payload: CalcRequest = { elementOne: inputs.n1, elementTwo: inputs.n2, operationType: op };

    try {
      const response = await axios.post(`${import.meta.env.VITE_API_URL}/math/operation`, payload,{ withCredentials: false });
      setResult(response.data.result);
    } catch (error) {
      console.error("Math error!", error);
    }
  };

  return (
    <div style={{ padding: '20px', border: '1px solid #ccc' }}>
      <input type="number" onChange={(e) => setInputs({...inputs, n1: +e.target.value})} />
      <input type="number" onChange={(e) => setInputs({...inputs, n2: +e.target.value})} />

      <div className="buttons">
        <button onClick={() => handleCalc('sum')}>+</button>
        <button onClick={() => handleCalc('minus')}>-</button>
        <button onClick={() => handleCalc('multiply')}>*</button>
        <button onClick={() => handleCalc('divide')}>/</button>
      </div>

      <h3>Result: {result}</h3>
    </div>
  );
};

export default Calculator;