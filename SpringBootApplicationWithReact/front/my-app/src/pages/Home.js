import React,{ Component} from 'react';
import { Button } from '@material-ui/core';
import Link from '@material-ui/core/Link';
import Carousel from 'react-material-ui-carousel';
import { Paper } from '@material-ui/core'

const sliderItems = [
    {
        id: "98",
        name: "Photo 1",
        url: "https://i.ibb.co/dkpHPXQ/1million-ENG.jpg"
    },
    {
        id: "59",
        name: "Photo 2",
        url: "https://i.ibb.co/C0vbNcy/dior-ENG.jpg"
    },
  ];
  function Item(props)
  {
      return (
          <Paper>
              
              <a href="/parfumuri">
                                  <img className="d-block w-100" src={props.item.url} alt={props.item.name} width = "1600" height = "800"/>
                              </a>
  
             
          </Paper>
      )
  }  
class Home extends Component{
    render()
    {
        return(
            <div>
            <Carousel>
                {
                sliderItems.map((item, index) => 
                <Item key={index} item={item} /> )
                }
            </Carousel>
          </div>
        )
    }

}
export default Home;