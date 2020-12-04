import React, { useState } from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import About from './components/About.js';
import Home from './components/Home.js';
import Pricing from './components/Pricing.js';
import NavBar from './components/NavBar.js';
import ErrorPage from './components/ErrorPage.js';

const App = ()=> {

  let initialPricing = [
    {level: "Hobby", cost: 0},
    {level: "Startup", cost: 10},
    {level: "Enterprise", cost: 100}
  ]

  const [pricing, setPricing] = useState(initialPricing);
  
  return (
    <Router>
      <>
        <NavBar />
        <Switch>
        <Route exact path="/" component={Home} />  
        <Route path="/about" component={About} />
        <Route 
        path="/pricing"
        render={() => <Pricing prices={pricing} />} />
        <Route component={ErrorPage} />
        </Switch>
      </>

    </Router>
  )

}

export default App;
