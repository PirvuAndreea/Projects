import React from "react";
import { Route, Link, Redirect, Switch, withRouter } from "react-router-dom";
import { Avatar, Button, List, ListItemIcon, ListItem, ListItemText, Typography, TextField  } from '@material-ui/core';
import axiosInstance from "../axios";
class ModificaCantitate extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
     id:this.props.data,
     valoare:0,
     cantitate:0,
     parfum:"",
    };
  
  }

  handleInput = event => {
    const {value,name} = event.target;
    console.log(value);
    this.setState({
        [name]:value
    })
}


componentDidMount(){
    axiosInstance.get("http://localhost:8080/produsComanda/" + this.props.data )
        .then(res => {
            let produs = res.data;
            this.setState({
                id:produs.id,
                valoare:produs.valoare,
                cantitate:produs.cantitate,
                parfum:produs.parfum,
                
               

            
            });
            
            console.log(res.data)
            console.log(this.props.data)
        }

        )
        .catch(error => {
            console.log(error)
        })



}

  handleSubmit2 = event => {
    event.preventDefault();
    let p = {
       id:this.state.id,
       valoare:this.state.valoare,
       cantitate:this.state.cantitate,
       parfum:this.state.parfum,
       
       
        
    }
    this.props.history.push("/shopping")

    
    axiosInstance.put("http://localhost:8080/produsComanda/update", p)
    .then(
        res => {
            console.log(res.data)
            console.log(res.data.mesaj)
            p = res.data;
            console.log(res.data);
            
        }
    )
    .catch(error => {
        console.log(error)
    });
}

  render() {
    return (
      <div className="ModificaCantitate">
        
        <form onSubmit={this.handleSubmit2}>

                    <Typography variant="h6" color="textPrimary" component="h6">
                       
            </Typography>
                    
                       
                   
                            <Typography
                                variant="subtitle2"
                                color="textPrimary"
                                component="h2"
                            >
                                
                </Typography>
                            <TextField
                                required={false}
                                type="hidden"
                                value = {this.state.id}
                                id="required"
                               
                                name="id"
                                placeholder="id"
                                onChange={this.handleInput}
                                margin="normal"
                              
                                autoComplete="off"
                            />
                        


                      
                            <Typography
                                variant="subtitle2"
                                color="textPrimary"
                                component="h2"
                            >
                                
                </Typography>
                            <TextField
                                required={false}
                                type="hidden"
                                value = {this.state.valoare}
                                id="required"
                               
                                name="valoare"
                                placeholder="valoare"
                                onChange={this.handleInput}
                                margin="normal"
                              
                                autoComplete="off"
                            />
                  
                      
                            <Typography
                                variant="subtitle2"
                                color="textPrimary"
                                component="h2"
                            >
                                
                </Typography>
                            <TextField
                                required={false}
                               // value = {this.state.cantitate}
                                id="required"
                                label="Cantitate"
                                name="cantitate"
                                placeholder="cantitate"
                                onChange={this.handleInput}
                                margin="normal"
                                variant="outlined"
                                autoComplete="off"
                            />
                        
                            <Typography
                                variant="subtitle2"
                                color="textPrimary"
                                component="h2"
                            >
                                
                </Typography>
                            <TextField
                                required={false}
                                type="hidden"
                                value = {this.state.parfum}
                                id="required"
                               
                                name="parfum"
                                placeholder="parfum"
                                onChange={this.handleInput}
                                margin="normal"
                               
                                autoComplete="off"
                            />
                   

                   <Button
                        onClick={() => {
                          
                          
                             
                            window.location.href = "/shopping"
                                                    
                         
                          }}
                            variant="contained"
                            color="secondary"
                            id="create"
                            type="submit"
                        >
                           Adauga cantitatea
              </Button>

                       {this.state.cantitate>this.state.parfum.cantitate?
                       <div>
                           Cantitate indisponibila
                          <p>Stoc disponibil: {this.state.parfum.cantitate}</p> 
                       </div>
                       
                    
                    :null}
                    
                </form>
                
      </div>
    );
  }
}
export default ModificaCantitate;