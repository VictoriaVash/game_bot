require: slotfilling/slotFilling.sc
  module = sys.zb-common
require: functions.js
theme: /

    state: Start
        q!: $regex</start>
        a: Молви, друг, и войди.
        
        state: Melon
            q: (melon|мелон)
            a: Перед тобой три коридора, в какой войдешь? 
            
            state: Left
                q: * *лев* *
                a: Съел дракон.
                go!: /Start/Melon
                    
            
            state: Right
                q: направо
                a: Коня потеряешь
                
                
            state: Strait
                q: * *прям* *
                a: Перед вами сундук, что будете делать?
                
                state: Open
                    script:
                        $session.number = getRandomInt(250)
                    q: * (~сломать|~открывать|~вскрывать) *
                    a: Вам выпали монеты, ровно  {{$session.number}} монеты
                    
                    state: GetNumber
                        script:
                            $session.number = $jsapi.random(100) + 1
                        go!: /Confirm
                    
                    state: ПотратитьМонеты
                        intent: /Число
                        script:
                            var num = $parseTree._Number;;
            
            
        state: NoMelon
            event: noMatch
            a: На эльфийском
        
    state: NoMatch
        event!: noMatch
        a: Перефразируйте текст, ничего не понятно.

