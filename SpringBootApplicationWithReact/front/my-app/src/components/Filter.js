import React,{ Component} from 'react';

class Filter extends Component{
    render()
    {
        return(
            <div className="row">
            <div className="col-md-4">
                {this.props.count} products found
            </div>
            <div className="col-md-4"></div>
            <label>
                Order by
                <select className="form-control" value={this.props.sort}
                onChange={this.props.handleChangeSort}>
                    <option value=" ">select</option>
                    <option value="Lowest">lowest to highest</option>
                    <option value="Highest">highest to Lowest</option>
                </select>
            </label>
            <div className="col-md-4"></div>
            <label>
                Filter brand
                <select className="form-control" value={this.props.size}
                onChange={this.props.handleChangeSize}>
                    <option value=" ">All</option>
                    <option value="Armani">Armani</option>
                    <option value="Carolina">Carolina</option>
                    <option value="Cristian Dior">Cristian Dior</option>
                    <option value="Paco Rabanne">Paco Rabanne</option>
                    <option value="Jean Paul Gaultier">Jean Paul Gaultier</option>
                    <option value="Thierry Mugler">Thierry Mugler</option>
                </select>
            </label>
            

            </div>
        )
    }

}
export default Filter;