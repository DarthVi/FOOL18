push 0
push function4
push function5
lfp
push 1
push 4
push 3
push 2
lfp
push -3
lfp
add
lw
js
lfp
push 1
push 2
push 3
push 3
lfp
push -3
lfp
add
lw
js
lfp
push -4
lfp
add
lw
copy
lw
push 1
add
lc
js
lfp
push -5
lfp
add
lw
copy
lw
push 1
add
lc
js
add
halt

function0:
cfp
lra
push 1
push 0
lfp
add
lw
calchoff
add
lw
push 2
push 0
lfp
add
lw
calchoff
add
lw
push 3
push 0
lfp
add
lw
calchoff
add
lw
add
add
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
push 1
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
push 4
push 0
lfp
add
lw
calchoff
add
lw
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
lfp
push 0
lfp
add
lw
copy
lw
push 0
add
lc
js
push 2
div
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
push 1
srv
sra
pop
pop
pop
pop
pop
sfp
lrv
lra
js

function5:
cfp
lra
push 1
lfp
add
lw
push 2
lfp
add
lw
add
push 3
lfp
add
lw
push 4
lfp
add
lw
add
beq label2
push 0
b label3
label2:
push 1
label3:
push 1
beq label0
push 1
lfp
add
lw
push 2
lfp
add
lw
push 3
lfp
add
lw
push 3
push classC
new
b label1
label0:
push 1
lfp
add
lw
push 2
lfp
add
lw
push 3
lfp
add
lw
push 4
lfp
add
lw
push 4
push classB
new
label1:
srv
sra
pop
pop
pop
pop
pop
sfp
lrv
lra
js
classA:
function0
function1
classB:
function0
function2
classC:
function0
function3
classnull:
