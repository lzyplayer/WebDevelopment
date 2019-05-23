import React, {PureComponent} from 'react';

class List extends PureComponent {
    constructor(props) {
        super(props);
        this.state = {
            todoList: [
                {
                    id: 1,
                    task: 'yoga',
                    hide: false,
                    finish:false
                },
                {
                    id: 2,
                    task: 'awsl',
                    hide: false,
                    finish:false
                }
            ],
            currLine: ''
        };
        this.handleChange = this.handleChange.bind(this);

        // this.addTask = ;
        // this.hideTask = this.hideTask()

    }

    handleChange(event) {
        this.setState({currLine: event.target.value})
    }
    finishTask(id){
        const currList = this.state.todoList;
        for (var i=0;i<currList.length;i++){
            if (currList[i].id===id){
                currList[i].finish=true;
            }
        }

        this.setState({todoList:currList});
        this.forceUpdate();
        console.log('successful hide '+id);
    }
    hideTask(id) {
        // console.log(id);
        const currList = this.state.todoList;
        for (var i=0;i<currList.length;i++){
            if (currList[i].id===id){
                currList[i].hide=true;
            }
        }

        this.setState({todoList:currList});
        this.forceUpdate();
        console.log('successful hide '+id);

    }

    addTask() {
        const oriList = this.state.todoList;
        const content = this.state.currLine;
        const inputList = [{
            id: this.state.todoList.length + 1,
            task: content,
            hide: false,
            finish:false
        }];
        const currList = oriList.concat(inputList);
        this.setState({todoList: currList,currLine:''});

        // console.log(this.refs.Task.value);

    }

    render() {

        const currLine = this.state.currLine;
        return (
            <div>
                <h1>TODO List</h1>
                <div className={'listWapper'}>
                    {
                        this.state.todoList.map(i => {
                                if (i.hide === false) {
                                    if (i.finish===false) {
                                        return (
                                            <div key={i.id} style={{
                                                display: 'inline-block',
                                                width: '100px',
                                                height: '50px',
                                                backgroundColor: 'yellow',
                                                fontSize: '20px',
                                                textAlign: 'center'
                                            }}>
                                                <p>{i.id}</p>

                                                <p onClick={this.finishTask.bind(this, i.id)}>{i.task}</p>
                                                <button onClick={this.hideTask.bind(this, i.id)}>x</button>
                                            </div>
                                        )
                                    }
                                    else{return (
                                        <div key={i.id} style={{
                                            display: 'inline-block',
                                            width: '100px',
                                            height: '50px',
                                            backgroundColor: 'yellow',
                                            fontSize: '20px',
                                            textAlign: 'center'
                                        }}>
                                            <p>{i.id}</p>

                                            <p onClick={this.finishTask.bind(this, i.id)}><s>{i.task}</s></p>
                                            <button onClick={this.hideTask.bind(this, i.id)}>x</button>
                                        </div>
                                    )}

                                }
                                else {return (
                                    <div key={i.id} style={{display: 'inline-block'}}/>

                                )}
                            }
                        )
                    }
                </div>
                <div>
                    <input type="text" value={currLine} onChange={this.handleChange}/>
                    <button onClick={this.addTask.bind(this)}>add</button>
                </div>
            </div>
        )
    }
}

export default List