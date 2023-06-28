import React, { useEffect , useState} from "react";
import { Card, Row, Col, Form } from "reactstrap";

import { accountDataService } from "../../services/accountService";
import "./dashboard.css";

export default function Dashboard(test){
    const [accounts, setAccounts] = useState([])

    useEffect(() =>{
        RetrievAccounts();
    },[])

    function RetrievAccounts(){
        accountDataService.getAccounts().then(response =>{
            console.log(response.data)
            setAccounts(response.data.accounts)
        })
        .catch( e =>{
            console.log(e)
        })
    }

    function changeUser(e){
        
    }

    return(
        <div className="dashboard">
            <div className="header">
                <form className="change-user" onSubmit={changeUser}>
                    <input type="email" className="emailInput" placeholder="Email" />
                    <button type="submit" className="submit-button">
                        Change
                    </button>
                </form>
            </div>
            <div className="dashboard-body">
                <Form>
                <Row>
                    {accounts.map((account) =>{
                        return(
                            <Col>
                                <Card className="account">
                                    <Card.Title>{account.name} </Card.Title>
                                    <Card.Text>IBan: {account.iban}</Card.Text>
                                    <Card.Text>Betrag: {account.value}</Card.Text>
                                    <Card.Text>Beschreibung: {account.description}</Card.Text>
                                </Card>
                            </Col>
                        )
                    })}
                </Row>
                </Form>
            </div>
        </div>
    )
}