import React , {useState} from "react"
import { Avatar, Button, List, ListItemIcon, ListItem, ListItemText, Typography, TextField  } from '@material-ui/core';
import axiosInstance from "../axios";
import { makeStyles } from '@material-ui/core/styles';
import GridList from '@material-ui/core/GridList';
import GridListTile from '@material-ui/core/GridListTile';
import GridListTileBar from '@material-ui/core/GridListTileBar';
import IconButton from '@material-ui/core/IconButton';
import InfoIcon from '@material-ui/icons/Info';




class UpdateParfum extends React.Component {

    
   

    constructor(){
        super();
        this.state = {
         id: localStorage.getItem("IDPARFUM") ,
         numeparfum:"",
         producator:"",
         anfabricatie:"",
         tara:"",
         genparfum:"",
         continut:"",
         descriere:"",
         pret:"",
         cantitate:"",
         tip:"",
         filename:"",
         incos:"",
         reviewList:[],
   
   

           
           
        }

    
    }


    componentDidMount(){
        axiosInstance.get("http://localhost:8080/parfum/" + this.state.id )
        .then(res => {
            let parfum = res.data;
            this.setState({
                id:parfum.id,
                numeparfum:parfum.numeparfum,
                producator:parfum.producator,
                anfabricatie:parfum.anfabricatie,
                tara:parfum.tara,
                genparfum:parfum.genparfum,
                continut:parfum.continut,
                descriere:parfum.descriere,
                pret:parfum.pret,
                cantitate:parfum.cantitate,
                tip:parfum.tip,
                filename:parfum.filename,
                incos:parfum.incos,
                reviewList:parfum.reviewList,

            });
            
            console.log(res.data)
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
         let parf = {
            id:this.state.id,
            numeparfum:this.state.numeparfum,
            producator:this.state.producator,
            anfabricatie:this.state.anfabricatie,
            tara:this.state.tara,
            genparfum:this.state.genparfum,
            continut:this.state.continut,
            descriere:this.state.descriere,
            pret:this.state.pret,
            cantitate:this.state.cantitate,
            tip:this.state.tip,
            filename:this.state.filename,
            incos:this.state.incos,
            reviewList:this.state.reviewList,
            
             
         }
         this.props.history.push("/ListaParfumuri")

         
         axiosInstance.put("http://localhost:8080/parfum/update", parf)
         .then(
             res => {
                 console.log(res.data)
                 console.log(res.data.mesaj)
                 parf = res.data;
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

                <form onSubmit={this.handleSubmit}>
                    <Typography variant="h6" color="textPrimary" component="h6">
                        Update parfum
            </Typography>
                    <div>
                       
                    <div>
                            <Typography
                                variant="subtitle2"
                                color="textPrimary"
                                component="h2"
                            >
                                Id:
                </Typography>
                            <TextField
                                required={true}
                                value = {this.state.id}
                                id="required"
                                label="Id Parfum"
                                name="id"
                                placeholder="id"
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
                                Nume parfum:
                </Typography>
                            <TextField
                                required={true}
                                value = {this.state.numeparfum}
                                id="required"
                                label="Nume parfum"
                                name="numeparfum"
                                placeholder="numeparfum"
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
                                Producator:
                </Typography>
                            <TextField
                                required={true}
                                value = {this.state.producator}
                                id="required"
                                label="Producator"
                                name="producator"
                                placeholder="producator"
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
                                An fabricatie:
                </Typography>
                            <TextField
                                required={true}
                                value = {this.state.anfabricatie}
                                id="required"
                                label="An fabricatie"
                                name="anfabricatie"
                                placeholder="anfabricatie"
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
                                An fabricatie:
                </Typography>
                            <TextField
                                required={true}
                                value = {this.state.anfabricatie}
                                id="required"
                                label="An fabricatie"
                                name="anfabricatie"
                                placeholder="anfabricatie"
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
                                Tara:
                </Typography>
                            <TextField
                                required={true}
                                value = {this.state.tara}
                                id="required"
                                label="Tara"
                                name="tara"
                                placeholder="tara"
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
                                Gen parfum:
                </Typography>
                            <TextField
                                required={true}
                                value = {this.state.genparfum}
                                id="required"
                                label="Gen parfum"
                                name="genparfum"
                                placeholder="genparfum"
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
                                Continut:
                </Typography>
                            <TextField
                                required={true}
                                value = {this.state.continut}
                                id="required"
                                label="Continut"
                                name="continut"
                                placeholder="continut"
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
                                Descriere:
                </Typography>
                            <TextField
                                required={true}
                                value = {this.state.descriere}
                                id="required"
                                label="Descriere"
                                name="descriere"
                                placeholder="descriere"
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
                                Pret:
                </Typography>
                            <TextField
                                required={true}
                                value = {this.state.pret}
                                id="required"
                                label="Pret"
                                name="pret"
                                placeholder="pret"
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
                                Cantitate:
                </Typography>
                            <TextField
                                required={true}
                                value = {this.state.cantitate}
                                id="required"
                                label="Cantitate"
                                name="cantitate"
                                placeholder="cantitate"
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
                                Tip:
                </Typography>
                            <TextField
                                required={true}
                                value = {this.state.tip}
                                id="required"
                                label="Tip"
                                name="tip"
                                placeholder="tip"
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
                                Filename:
                </Typography>
                            <TextField
                                required={true}
                                value = {this.state.filename}
                                id="required"
                                label="Filename"
                                name="filename"
                                placeholder="filename"
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
                                Incos:
                </Typography>
                            <TextField
                                required={true}
                                value = {this.state.incos}
                                id="required"
                                label="In cos"
                                name="incos"
                                placeholder="incos"
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
                                
                </Typography>
                            <TextField
                                required={false}
                                type="hidden"
                                value = {this.state.reviewList}
                                id="required"
                               
                                name="reviewList"
                                placeholder="reviewList"
                                onChange={this.handleInput}
                                margin="normal"
                                
                                autoComplete="off"
                            />
                        </div>



                    </div>
                    <div id="buttons">
                        <Button
                        onClick={() => {
                          
                            window.location.href = "/ListaParfumuri"
                           
                         
                          }}
                            variant="contained"
                            color="secondary"
                            id="create"
                            type="submit"
                        >
                            Update Parfum
              </Button>
                    </div>
                </form>
            </React.Fragment>
               
                
                    
        )
        
        }         
        else
        {
            throw new Error("Doar administratorul are acces");
        }   
                    
                    
    }




}

export default UpdateParfum;