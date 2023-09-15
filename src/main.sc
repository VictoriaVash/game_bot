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
            
        state: NoMelon
            event: noMatch
            a: На эльфийском
        
    state: NoMatch
        event!: noMatch
        a: Перефразируйте текст, ничего не понятно.

