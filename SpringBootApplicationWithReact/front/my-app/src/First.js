import React , {useState} from "react"
import { Avatar, Button, List, ListItemIcon, ListItem, ListItemText, Typography, TextField  } from '@material-ui/core';
import axiosInstance from "./axios";
import { makeStyles } from '@material-ui/core/styles';
import GridList from '@material-ui/core/GridList';
import GridListTile from '@material-ui/core/GridListTile';
import GridListTileBar from '@material-ui/core/GridListTileBar';
import IconButton from '@material-ui/core/IconButton';
import InfoIcon from '@material-ui/icons/Info';




class First extends React.Component {

    
   

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


    
    
     ceva(idd)
         {
            this.setState({ idParf: idd});
    
         }
    

    

    buttonClicked(event) {
        this.setState({value: this.state.value+1});
        localStorage.setItem("COUNT", this.state.value);
    }
    

    componentDidMount(){
        axiosInstance.get("http://localhost:8080/parfum")
        .then(res => {
            const val = res.data;
            this.setState({
                parfumuri: val
            });
            console.log(val);
            console.log(this.state.parfumuri)
        }

        )
        .catch(error => {
            console.log(error)
        })





        axiosInstance.get("http://localhost:8080/review/" + this.state.review.autor0)
        .then(res => {
            const val = res.data;
            this.setState({
                review: val
            });
            console.log(val);
            console.log(this.state.review)
        }

        )
        .catch(error => {
            console.log(error)
        })
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
            parfumID:this.state.idParfum,
            //reviewID:this.state.idReview
            autorrev: this.state.autor,
            mesajrev: this.state.mesaj
        }
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


    handleSubmit1 = event => {
       
        event.preventDefault();
      
        let ParfumCos = {
            //trebuie sa se numeasca la fel ca in java in dto
            id:this.state.idParf,
            //reviewID:this.state.idReview
            incos:true,
        }
        axiosInstance.put("http://localhost:8080/parfum/addCart", ParfumCos)
        .then(
            res => {
                console.log(res.data.id)
                ParfumCos = res.data;
                console.log(res.data);
            }
        )
        .catch(error => {
            console.log(error)
        });
    }


    
   
  

    

     render() {
        
         
        
        

        if( localStorage.getItem("ROLE") === "ADMIN")
        {
        
        return (
            
           
            <React.Fragment>

                

               
                <List>
                    {this.state.parfumuri.map(parfum => (
                        <ListItem>
                            
                            <img src={parfum.filename} alt={parfum.numeparfum}  height="100" width="100"/>
                            
                            <ListItemText primary = {parfum.id + " " + parfum.numeparfum + " " + parfum.producator + " "
                            + parfum.incos 
                            
                           
                             }
                            
                            secondary = {"Review-uri: " + parfum.reviewList.map(review => review.mesaj + " ")} />

                         <form onSubmit={this.handleSubmit1}>
                            <Button
                           onClick={() => {
                            this.buttonClicked();
                            this.ceva(parfum.id);
                          }}
                           
                            variant="contained"
                            color="black"
                            id="create"
                            type="submit" >
                                Add to cart
                            </Button>
                         </form>

                        </ListItem>
                       

                    ))}
                </List>
               
              
                
                

                

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
                                Parfum ID:
                </Typography>
                            <TextField
                                required={true}
                                id="required"
                                label="Parfum ID"
                                name="idParfum"
                                placeholder="Parfum"
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
                            variant="contained"
                            color="primary"
                            id="create"
                            type="submit"
                        >
                            Update Review
              </Button>
                    </div>
                </form>

                <br></br>
                <div >
      <GridList cellHeight={100}   cols={3} >
            {this.state.parfumuri.map((parfum) => (
                 
                
             <GridListTile key={parfum.id} cols={ 1}>
              <img src={parfum.filename} alt={parfum.numeparfum}  height="100" width="100"/>
              
                
              <Button>
                  Hei
              </Button>
             </GridListTile>

            


              
               
                
              
           ))}
           
           
           
           
         </GridList>
              </div>


                        

                
            </React.Fragment>
               
                
                    
        )
                    }
                    else
                    {
                        throw new Error("Doar administratorul are acces");
                    }
                    
                    
    }




}

export default First;