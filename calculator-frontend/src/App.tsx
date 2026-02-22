import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import calculatorLogo from './assets/cal.png'
import CalculatorButton from './calcbutton'
import axios from 'axios'
import Calculator from './calculator'
import HistoryList from './history'
import './App.css'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <div>
        {/* <a href="https://vite.dev" target="_blank">
          <img src={viteLogo} className="logo" alt="Vite logo" />
        </a>
        <a href="https://react.dev" target="_blank">
          <img src={reactLogo} className="logo react" alt="React logo" />
        </a> */}
        <br />
        <a >
        <img src={calculatorLogo} className="logo calculator" alt="Calculator logo" />
        </a>
        <h1 className='buttons'>
          {/* <CalculatorButton label="7" onClick={(value) => console.log(value)} />
          <CalculatorButton label="8" onClick={(value) => console.log(value)} />
          <CalculatorButton label="9" onClick={(value) => console.log(value)} />
          <CalculatorButton label="x" onClick={(value) => console.log(value)} />
          <br />
          <CalculatorButton label="4" onClick={(value) => console.log(value)} />
          <CalculatorButton label="5" onClick={(value) => console.log(value)} />
          <CalculatorButton label="6" onClick={(value) => console.log(value)} />
          <CalculatorButton label="-" onClick={(value) => console.log(value)} />
          <br />
          <CalculatorButton label="1" onClick={(value) => console.log(value)} />
          <CalculatorButton label="2" onClick={(value) => console.log(value)} />
          <CalculatorButton label="3" onClick={(value) => console.log(value)} />
          <CalculatorButton label="+" onClick={(value) => console.log(value)} />
          <br />
          <CalculatorButton label="0" onClick={(value) => console.log(value)} />  
          <CalculatorButton label="." onClick={(value) => console.log(value)} />  
          <CalculatorButton label="<-" onClick={(value) => console.log(value)} />  
          <CalculatorButton label="=" onClick={(value) => console.log(value)} /> */}
            
        </h1>
      </div>
      <Calculator />
      <HistoryList />
      {/* <h1>Vite + React</h1> */}
      <div className="card">
        <button onClick={() => setCount((count) => count + 1)}>
          count is {count}
        </button>
        <p>
          Edit <code>src/App.tsx</code> and save to test HMR
        </p>
      </div>
      <p className="read-the-docs">
        Click on the Vite and React logos to learn more
      </p>
    </>
  )
}

export default App
