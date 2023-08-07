import 'bootstrap/dist/css/bootstrap.min.css';
import React, { useState } from "react";
import { Routes, Route} from 'react-router-dom';
import { Bonds } from "./components/bonds/Bonds";
import Auth  from "./components/auth/Auth";
import styles from "./App.css";
import AllSecurities from './components/security/AllSecurities';

const App = () => {
  const [isAutheticated, setIsAuthenticated] = useState(false);
  const [email, setEmail] = useState("");

  const getAuth = (authState, email) => {
    setIsAuthenticated(authState);
    setEmail(email);
    
  };

  return (
    <Routes>
        <Route path="/bonds" element={<AllSecurities authState={isAutheticated} getAuth={getAuth} info={email}/>} />
        {/* <Route path="/bonds" element={<Bonds authState={isAutheticated} getAuth={getAuth}/>} /> */}
        <Route path="/" element={<Auth getAuth={getAuth}/>} />
    </Routes>
    //<Bonds />
  )
};

export default App;
