push 0
push 0
push classF
new
push 0
push classC
new
push 1
push 1
beq label0
push -3
lfp
add
lw
b label1
label0:
push -2
lfp
add
lw
label1:
lfp
push -4
lfp
add
lw
copy
lw
push 0
add
lc
js
halt

function0:
cfp
lra
push 18
srv
sra
pop
sfp
lrv
lra
js

function1:
cfp
lra
push 2
srv
sra
pop
sfp
lrv
lra
js

function2:
cfp
lra
push 5
srv
sra
pop
sfp
lrv
lra
js

function3:
cfp
lra
push 3
srv
sra
pop
sfp
lrv
lra
js

function4:
cfp
lra
push 7
srv
sra
pop
sfp
lrv
lra
js

function5:
cfp
lra
push 8
srv
sra
pop
sfp
lrv
lra
js

function6:
cfp
lra
push 10
srv
sra
pop
sfp
lrv
lra
js
classA:
function0
classB:
function0
function1
classC:
function0
function2
function3
classD:
function0
function2
classE:
function0
function1
function4
classF:
function0
function1
function5
function6
classH:
function0
function1
function5
classnull:
