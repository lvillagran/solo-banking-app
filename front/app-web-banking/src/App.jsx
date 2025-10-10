import { useState } from 'react'
import './index.css';
import Login  from './componentes/Login'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
       <Login />
    </>
  )
}

export default App