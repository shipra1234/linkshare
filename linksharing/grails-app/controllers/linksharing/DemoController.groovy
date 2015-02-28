package linksharing

class DemoController {

    def index() {}

    def action1(){
        render(view: 'demo1',model: [usernameAction1:"komal jain"])
    }
    def action2(){
        render(view: 'demo2',model: [usernameAction2:"Shipra Tayal"])
    }
}
