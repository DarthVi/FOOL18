push 0
push function3
lfp
push 2
lfp
push -2
lfp
add
lw
js
lfp
push -3
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
push 1
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

function1:
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

function2:
cfp
lra
push 5
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
push 1
push 0
push 3
push 3
push classblock
new
push 1
push 0
push 3
push 7
push -2
lfp
add
lw
push 5
push classbblock
new
push 1
lfp
add
lw
push 0
beq label2
push 0
b label3
label2:
push 1
label3:
push 1
beq label0
lfp
push 1
lfp
add
lw
push 1
sub
lfp
lw
push -2
lfp
lw
add
lw
js
b label1
label0:
push -3
lfp
add
lw
label1:
srv
pop
pop
sra
pop
pop
sfp
lrv
lra
js
classbblock:
function1
function2
classblock:
function0
classnull:
