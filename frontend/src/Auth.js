import React, { useState } from "react";
import './Auth.css'

export default function (props){
    const[user, setUser] = useState({
        email:"",
        password: "",
    });

    const[email, setEmail] = useState("");
    const[password, setPassword] = useState("");

    function checkUser(e){
        setEmail(e.email);
        setPassword(e.password);
        console.log(email);
        console.log(password);
    }


    return(
          <div className="Auth-form-container">
            <form className="Auth-form" onSubmit={checkUser}>
                <div className="Auth-form-content">
                    <h3 className="Auth-form-title">Sign In</h3>
                    <div className="form-group">
                        <label>Email</label>
                        <input type="email" className="form-control" placeholder="Enter Email" />
                    </div>
                    <div className="form-group">
                        <label>Password</label>
                        <input type="password" className="form-control" placeholder="Enter Password" />
                    </div>
                    <div className="form-group-2">
                        <button type="submit" className="submit-button">
                            Submit
                        </button>
                    </div>
                </div>
            </form>
          </div>
    )
}