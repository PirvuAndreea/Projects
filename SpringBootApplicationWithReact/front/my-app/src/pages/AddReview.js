import React , {useState} from "react"
import { Avatar, Button, List, ListItemIcon, ListItem, ListItemText, Typography, TextField  } from '@material-ui/core';
import axiosInstance from "../axios";
import { makeStyles } from '@material-ui/core/styles';
import GridList from '@material-ui/core/GridList';
import GridListTile from '@material-ui/core/GridListTile';
import GridListTileBar from '@material-ui/core/GridListTileBar';
import IconButton from '@material-ui/core/IconButton';
import InfoIcon from '@material-ui/icons/Info';




class AddReview extends React.Component {

    
   

    constructor(){
        super();
        this.state = {
            value: 0,
            parfumuri: [],
            review :{
                id:0,
                autor0: "Andreea"
            },
            idParfum : 0,
           // idReview : 0,
           autor: "",
           mesaj: "",

           idParf: "",

           
           

        }

    
    }


    
    handleInput = event => {
        const {value,name} = event.target;
        console.log(value);
        this.setState({
            [name]:value
        })
    }

    handleSubmit = event => {
        event.preventDefault();
        let ParfumReview = {
            //trebuie sa se numeasca la fel ca in java in dto
            parfumID:localStorage.getItem("IDPARFUM"),
            //reviewID:this.state.idReview
            autorrev: this.state.autor,
            mesajrev: this.state.mesaj
        }
        this.props.history.push("/parfumuri")
        axiosInstance.put("http://localhost:8080/parfum", ParfumReview)
        .then(
            res => {
                console.log(res.data)
                console.log(res.data.mesaj)
                ParfumReview = res.data;
                console.log(res.data);
            }
        )
        .catch(error => {
            console.log(error)
        });
    }


   


     render() {
        

        if( localStorage.getItem("ROLE") !== "ADMIN")
        {
        
        return (
            
           
            <React.Fragment>

                <form onSubmit={this.handleSubmit}>
                    <Typography variant="h6" color="textPrimary" component="h6">
                        ADD Review to Parfum
            </Typography>
                    <div>
                       
                        <div>
                            <Typography
                                variant="subtitle2"
                                color="textPrimary"
                                component="h2"
                            >
                                Autor Review:
                </Typography>
                            <TextField
                                required={true}
                                id="required"
                                label="Autor Review"
                                name="autor"
                                placeholder="autor"
                                onChange={this.handleInput}
                                margin="normal"
                                variant="outlined"
                                autoComplete="off"
                            />
                        </div>
                        <div>
                            <Typography
                                variant="subtitle2"
                                color="textPrimary"
                                component="h2"
                            >
                                Review mesaj:
                </Typography>
                            <TextField
                                required={true}
                                id="required"
                                label="Review mesaj"
                                name="mesaj"
                                placeholder="mesaj"
                                onChange={this.handleInput}
                                margin="normal"
                                variant="outlined"
                                autoComplete="off"
                            />
                        </div>
                    </div>
                    <div id="buttons">
                        <Button
                          onClick={() => {
                          
                            window.location.href = "/parfumuri"
                         
                          }}
                            variant="contained"
                            color="secondary"
                            id="create"
                            type="submit"
                        >
                            Add Review
              </Button>
                    </div>
                </form>
            </React.Fragment>
               
                
                    
        )
        }
        else
    {
        throw new Error("Administratorul nu are acces");
    }
                    
                    
                    
                    
    }




}

export default AddReview;