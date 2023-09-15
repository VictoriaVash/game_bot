require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Молви, друг, и войди.
        
        state: Melon
            q: melon
            a: Перед тобой три коридора, в какой войдешь? 
            
            state: Left
                q: * *лев* *
                a: Съел дракон
            
            state: Right
                q: * *прав* *
                a: 
                
                
            state: Strait
                q: * *прям* *
                a: Перед вами сундук, что будете делать?
                
                state: Open
                q: * (~сломать|~вскрыть|~открыть) *
                a: Вам выпали монеты, ровно монеты
            
            
        state: NoMelon
            event: noMatch
            a: На эльфийском
        
    state: NoMatch
        event!: noMatch
        a: Перефразируйте текст, ничего не понятно.

