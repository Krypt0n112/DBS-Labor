import React from 'react'
import { BrowserRouter as Router, Route } from 'react-router-dom';

import Auth from './Auth';

import 'bootstrap/dist/css/bootstrap.min.css'
import './App.css';

//Just for me 
/*const App = () => {
  const[users, setUsers] = useState([]);
  const[loading, setLoading] = useState(false);

  useEffect(() => {
    setLoading(true);

    fetch('/user/all')
      .then(response => response.json())
      .then(data => {
        setUsers(data);
        setLoading(false);
      })
  }, [])
*/

const App = () =>{
    return(
      <Router>
        <Route path="/auth" component={Auth} />
      </Router>
    )
}

export default App;
